package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Partido;
import com.example.lab9_base.Bean.Seleccion;
import com.example.lab9_base.Bean.Arbitro;
import com.example.lab9_base.Bean.Estadio;

import java.sql.*;
import java.util.ArrayList;

public class DaoPartidos {
    public ArrayList<Partido> listaDePartidos() {

        ArrayList<Partido> partidos = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/lab9";
        String username = "root";
        String password = "root";

        String sql = "SELECT\n" +
                "    p.idPartido,p.numerojornada,p.fecha,\n" +
                "    sl.nombre AS nombreSeleccionLocal,\n" +
                "    sv.nombre AS nombreSeleccionVisitante,\n" +
                "    e.nombre AS nombreEstadio,\n" +
                "    a.nombre AS nombreArbitro\n" +
                "FROM\n" +
                "    partido p\n" +
                "JOIN\n" +
                "    arbitro a ON p.arbitro = a.idArbitro\n" +
                "JOIN\n" +
                "    seleccion sl ON p.seleccionLocal = sl.idSeleccion\n" +
                "JOIN\n" +
                "    seleccion sv ON p.seleccionVisitante = sv.idSeleccion\n" +
                "JOIN\n" +
                "    estadio e ON sl.estadio_idEstadio=e.idEstadio";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                partido.setFecha(rs.getString(2));
                partido.setNumeroJornada(rs.getInt(3));

                Seleccion seleccion1 = new Seleccion();
                seleccion1.setIdSeleccion(rs.getInt("sl.idSeleccion"));
                seleccion1.setNombre(rs.getString("nombre"));
                partido.setSeleccionLocal(seleccion1);

                Seleccion seleccion2 = new Seleccion();
                seleccion1.setIdSeleccion(rs.getInt("sl.idSeleccion"));
                seleccion1.setNombre(rs.getString("nombre"));
                partido.setSeleccionVisitante(seleccion2);



                Arbitro arbitro= new Arbitro();
                arbitro.setIdArbitro(rs.getInt("a.idArbitro"));
                arbitro.setNombre(rs.getString("nombre"));
                partido.setArbitro(arbitro);

                Estadio estadio= new Estadio();
                estadio.setIdEstadio(rs.getInt("e.idEstadio"));
                estadio.setNombre(rs.getString("nombre"));
                partido.setEstadio(estadio);


                partidos.add(partido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return partidos;
    }

    public void crearPartido(Partido partido) {

        /*
        Inserte su código aquí
        */
    }
}
