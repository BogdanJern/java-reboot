package ru.sberbank.edu;


import org.h2.tools.Server;
import ru.sberbank.edu.dbconnection.H2DbEmbedded;
import ru.sberbank.edu.model.Car;
import ru.sberbank.edu.repository.CarDbRepositoryImpl;
import ru.sberbank.edu.repository.CarRepository;
import ru.sberbank.edu.service.CarService;
import ru.sberbank.edu.service.CarServiceImpl;

import java.util.*;

public class CarBootstrap {
    public static void main(String[] args) throws Exception {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("999","Fiat"));
        cars.add(new Car("111","KIA"));

        Server server = Server.createTcpServer(args).start();
        H2DbEmbedded.initDb();

        try(H2DbEmbedded h2DbEmbedded = new H2DbEmbedded()) {
            CarRepository carRepository = new CarDbRepositoryImpl(H2DbEmbedded.getConnection());
            CarService carService = new CarServiceImpl(carRepository);

            carService.addCar("777", "Lada");
            carService.addCar("888", "BMW");

            // Test check start
            //String readAllCarsSql = "SELECT * FROM car";
            //Statement statement = H2DbEmbedded.getConnection().createStatement();
            //ResultSet resultSet = statement.executeQuery(readAllCarsSql);
            System.out.println(carRepository.createAll(cars));
            System.out.println(carRepository.findAll());
            carRepository.deleteById("888");
            System.out.println(carRepository.findAll());
            //carRepository.deleteAll();
            //System.out.println(carRepository.findAll());

            System.out.println(carRepository.findByModel("KIA"));

           /* while (resultSet.next()) {
                String id = resultSet.getString(1);
                String model = resultSet.getString(2);
                System.out.println("id=" + id + "; model=" + model);
            }
            // Test end

            */
        }
        server.stop();
    }
}
