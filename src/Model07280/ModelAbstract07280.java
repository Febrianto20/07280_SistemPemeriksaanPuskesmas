package Model07280;

import Helper07280.KoneksiDb07280;

import java.sql.Connection;

public abstract class ModelAbstract07280 {
    public Connection conn = KoneksiDb07280.getconection();

    public abstract void updatenoTelp(String noTelp,int id);

    public abstract void updateNoTelp(String noTelp, int id);
}
