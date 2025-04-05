package project.postmantest.database;

public class ConnectionMaker {

    public static UserDatabase getUserDateBase() {
        return UserDatabase.getInstance();
    }
}