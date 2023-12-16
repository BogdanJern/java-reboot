<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
  <html>
  <head>
      <title>Калькулятор</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
      <h1>Калькулятор доходности вклада</h1>

        <form method="POST" action="">
        <label for="sum">Сумма на момент открытия</label>
        <input type="text" name="sum">
        <br>
        <label for="rate">Процентная ставка</label>
        <input type="text" name="rate">
        <br>
        <label for="name">Количество лет</label>
        <input type="text" name="years">
        <br>
        <input type="submit" value="Посчитать"/>
      </form>
  </body>
  </html>