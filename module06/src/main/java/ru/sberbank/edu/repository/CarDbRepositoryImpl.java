package ru.sberbank.edu.repository;


import ru.sberbank.edu.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CarDbRepositoryImpl implements CarRepository {
    private final Connection connection;
    private static final String CREATE_CAR_SQL = "INSERT INTO car (id, model) VALUES (?,?)";
    private static final String UPDATE_CAR_SQL = "UPDATE car SET model = ? WHERE id = ?";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE id = ?";
    private static final String SELECT_ALL_CAR = "SELECT * FROM car";
    private static final String DELETE_CAR_BY_ID = "DELETE FROM car WHERE id = ?";
    private static final String DELETE_ALL_CAR = "DELETE FROM car";
    private static final String SELECT_CAR_BY_MODEL = "SELECT * FROM car WHERE model = ?";

    private final PreparedStatement createPreStmt;
    private final PreparedStatement updatePreStmt;
    private final PreparedStatement findByIdPreStmt;
    private final PreparedStatement findAllPreStmt;
    private final PreparedStatement deleteByIdPreStmt;
    private final PreparedStatement deleteALLPreStmt;
    private final PreparedStatement findByModelPreStmt;

    public CarDbRepositoryImpl(Connection connection) throws SQLException {
        this.connection = connection;
        this.createPreStmt = connection.prepareStatement(CREATE_CAR_SQL);
        this.updatePreStmt = connection.prepareStatement(UPDATE_CAR_SQL);
        this.findByIdPreStmt = connection.prepareStatement(SELECT_CAR_BY_ID);
        this.findAllPreStmt = connection.prepareStatement(SELECT_ALL_CAR);
        this.deleteByIdPreStmt = connection.prepareStatement(DELETE_CAR_BY_ID);
        this.deleteALLPreStmt = connection.prepareStatement(DELETE_ALL_CAR);
        this.findByModelPreStmt = connection.prepareStatement(SELECT_CAR_BY_MODEL);
    }

    @Override
    public Car createOrUpdate(Car car) throws SQLException {
        Optional<Car> optCar = findById(car.getId());
        if (optCar.isEmpty()) {
            createPreStmt.setString(1, car.getId());
            createPreStmt.setString(2, car.getModel());
            createPreStmt.executeUpdate();
        } else {
            updatePreStmt.setString(1, car.getModel());
            updatePreStmt.setString(2, car.getId());
            updatePreStmt.executeUpdate();
        }
        return car;
    }

    /**
     * @param cars
     * @return
     */
    @Override
    public Set<Car> createAll(Collection<Car> cars) throws SQLException {
        HashSet<Car> set = new HashSet<>();
        List<Car> listCars = cars.stream().toList();
        for (int i = 0; i < cars.size(); i++){
            createPreStmt.setString(1, listCars.get(i).getId());
            createPreStmt.setString(2, listCars.get(i).getModel());
            createPreStmt.executeUpdate();
            set.add(new Car(listCars.get(i).getId(),listCars.get(i).getModel()));
        }
        return set;
    }

    /**
     * @return
     */
    @Override
    public Set<Car> findAll() throws SQLException {

        HashSet<Car> set = new HashSet<>();
        ResultSet resultSet = findAllPreStmt.executeQuery();
        while (resultSet.next()){
            Car car = new Car(resultSet.getString(1), resultSet.getString(2));
            set.add(car);
        }
        return set;
    }

    @Override
    public Optional<Car> findById(String id) throws SQLException {
        // validation
        int rowsCount = countRowsById(id);
        if (rowsCount > 1) {
            throw new RuntimeException("Car with id = " + id + " was found many times (" + rowsCount + ").");
        } else if (rowsCount == 0) {
            return Optional.empty();
        }

        findByIdPreStmt.setString(1, id);
        ResultSet resultSet = findByIdPreStmt.executeQuery();

        resultSet.next();
        Car car = new Car(resultSet.getString(1), resultSet.getString(2));
        return Optional.of(car);
    }

    @Override
    public Boolean deleteById(String id) throws SQLException {
        int rowsCount = countRowsById(id);
        if (rowsCount == 0) {
            throw new RuntimeException("Car with id = " + id + " was not found.");
        }
        deleteByIdPreStmt.setString(1,id);
        deleteByIdPreStmt.executeUpdate();
        return true;
    }

    /**
     * @return
     */
    @Override
    public Boolean deleteAll() throws SQLException {
        deleteALLPreStmt.executeUpdate();
        return true;
    }

    private int countRowsById(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM car where id = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount = resultSet.getInt(1);
        }
        return rowCount;
    }

    private int countRowsByModel(String model) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM car where model = ?");
        preparedStatement.setString(1, model);
        ResultSet resultSet = preparedStatement.executeQuery();
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount = resultSet.getInt(1);
        }
        return rowCount;
    }

    /**
     * @param model
     * @return
     */
    @Override
    public Set<Car> findByModel(String model) throws SQLException {
        HashSet<Car> cars = new HashSet<>();
        int rowsCount = countRowsByModel(model);
        if (rowsCount > 1) {
            throw new RuntimeException("Car with id = " + model + " was found many times (" + rowsCount + ").");
        }

        findByModelPreStmt.setString(1, model);
        ResultSet resultSet = findByModelPreStmt.executeQuery();

        while (resultSet.next()) {
            cars.add(new Car(resultSet.getString(1), resultSet.getString(2)));
        }
        return cars;
    }
}
