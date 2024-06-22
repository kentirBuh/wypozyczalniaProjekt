package com.example.wypozyczalnia.Exception;

public class DuplicateKlientException extends RuntimeException
{
    public DuplicateKlientException(String error)
    {
        super(error); //obsługuje error który występuje w razie próby stworzenia klienta z numerem telefonu który znajduje się już w naszej bazie danych
    }
}
