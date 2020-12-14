package ru.mirea.inbo_05_19.Kuznetsov;

import javax.swing.*;

public class EmptyOrderException extends Exception {
    EmptyOrderException() {
        JOptionPane.showMessageDialog(null, "Ваш заказ пуст. Добавьте предметы", "Your Order is Empty", JOptionPane.ERROR_MESSAGE);
    }
}