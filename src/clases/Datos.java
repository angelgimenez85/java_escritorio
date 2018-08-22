package clases;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {

    private Connection cnn;

    public String conectar() {
        try {            
            String path = "config" + System.getProperty("file.separator") + "db_config.properties";
            
            File fileConfig = new File(path);
            if (!fileConfig.exists()) {
                return "No se encontró el archivo de configuración";
            }

            Properties p = new Properties();
            p.load(new FileReader(path));            

            String driver = p.getProperty("driver");
            String db = p.getProperty("database");
            String user = p.getProperty("user");
            String password = p.getProperty("password");
            
            Class.forName(driver);
            cnn = DriverManager.getConnection(db, user, password);

            return "OK";

        } catch (Exception ex) {
            //Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "No se pudo conectar con la Base de Datos.\n"
                    + "Verifique la conexión y vuelva intentarlo.";
        }
    }

    public boolean validarUsuario(String usuario, String clave) {
        try {
            String sql = "select (1) from usuarios where idUsuario = '" + usuario
                    + "' and clave = '" + clave + "'";

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int getPerfil(String usuario) {
        try {
            String sql = "select idPerfil from usuarios where idUsuario = '"
                    + usuario + "'";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt("idPerfil");
            } else {
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public boolean existeUsuario(String usuario) {
        try {
            String sql = "select (1) from usuarios where idUsuario = '"
                    + usuario + "'";

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean existeCliente(String cliente) {
        try {
            String sql = "select (1) from clientes where idCliente = '"
                    + cliente + "'";

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean existeProducto(String producto) {
        try {
            String sql = "select (1) from productos where idProducto = '"
                    + producto + "'";

            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String agregarUsuario(Usuario miUsuario) {
        try {
            String sql = "insert into usuarios values('"
                    + miUsuario.getIdUsuario()
                    + "', '" + miUsuario.getNombres()
                    + "', '" + miUsuario.getApellidos()
                    + "', '" + miUsuario.getClave()
                    + "', " + miUsuario.getPerfil() + ", '')";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Usuario agregado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al insertar el usuario";
        }
    }

    public String agregarCliente(Cliente miCliente) {
        try {
            String sql = "insert into clientes values('"
                    + miCliente.getIdCliente()
                    + "', " + miCliente.getIdTipo()
                    + ", '" + miCliente.getNombres()
                    + "', '" + miCliente.getApellidos()
                    + "', '" + miCliente.getDireccion()
                    + "', '" + miCliente.getTelefono()
                    + "', " + miCliente.getIdCiudad()
                    + ", '" + Utilidades.formatDate(miCliente.getFechaNac())
                    + "', '" + Utilidades.formatDate(
                            miCliente.getFechaIngreso()) + "')";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Cliente agregado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al insertar el cliente";
        }
    }

    public String agregarProducto(Producto miProducto) {
        try {
            String sql = "insert into productos values('"
                    + miProducto.getIdProducto()
                    + "', '" + miProducto.getDescripcion()
                    + "', " + miProducto.getPrecio()
                    + ", " + miProducto.getIva()
                    + ", '" + miProducto.getNota() + "', '')";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Producto agregado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al insertar el producto";
        }
    }

    public String modificarUsuario(Usuario miUsuario) {
        try {
            String sql = "update usuarios set"
                    + " nombres = '" + miUsuario.getNombres() + "',"
                    + " apellidos = '" + miUsuario.getApellidos() + "', "
                    + " clave = '" + miUsuario.getClave() + "', "
                    + " idPerfil = " + miUsuario.getPerfil() + ", foto = ''"
                    + " where idUsuario = '" + miUsuario.getIdUsuario() + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Usuario modificado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al modificar el usuario";
        }
    }

    public String modificarCliente(Cliente miCliente) {
        try {
            String sql = "update clientes set"
                    + " idTipo = '" + miCliente.getIdTipo() + "',"
                    + " nombres = '" + miCliente.getNombres() + "',"
                    + " apellidos = '" + miCliente.getApellidos() + "',"
                    + " direccion = '" + miCliente.getDireccion() + "',"
                    + " telefono = '" + miCliente.getTelefono() + "',"
                    + " idCiudad = '" + miCliente.getIdCiudad() + "',"
                    + " fechaNacimiento = '" + Utilidades.formatDate(
                            miCliente.getFechaNac()) + "',"
                    + " fechaIngreso = '" + Utilidades.formatDate(
                            miCliente.getFechaIngreso()) + "'"
                    + " where idCliente = '" + miCliente.getIdCliente() + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Cliente modificado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al modificar el cliente";
        }
    }

    public String modificarProducto(Producto miProducto) {
        try {
            String sql = "update productos set"
                    + " descripcion = '" + miProducto.getDescripcion() + "',"
                    + " precio = " + miProducto.getPrecio() + ", "
                    + " idIVA = " + miProducto.getIva() + ", "
                    + " notas = '" + miProducto.getNota() + "', foto = ''"
                    + " where idProducto = '" + miProducto.getIdProducto() + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Producto modificado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al modificar el producto";
        }
    }

    public String borrarUsuario(String usuario) {
        try {
            String sql = "delete from usuarios where idUsuario = '" + usuario + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Usuario borrado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al borrar el usuario";
        }
    }

    public String borrarCliente(String cliente) {
        try {
            String sql = "delete from clientes where idCliente = '" + cliente + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Cliente borrado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al borrar el cliente";
        }
    }

    public String borrarProducto(String producto) {
        try {
            String sql = "delete from productos where idProducto = '" + producto + "'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return "Producto borrado correctamente";

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return "Ocurrió un error al borrar el producto";
        }
    }

    public ResultSet getUsuarios() {
        try {
            String sql = "select * from usuarios";
            Statement st = cnn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet getClientes() {
        try {
            String sql = "select * from clientes";
            Statement st = cnn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet getProductos() {
        try {
            String sql = "select * from productos";
            Statement st = cnn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet getProducto(String idProducto) {
        try {
            String sql = "select * from productos "
                    + "where idProducto = '" + idProducto + "'";
            Statement st = cnn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet getConsulta(String sql) {
        try {
            Statement st = cnn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int numeroUsuarios() {
        try {
            String sql = "select count(*) as num from usuarios";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int numeroClientes() {
        try {
            String sql = "select count(*) as num from clientes";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int numeroProductos() {
        try {
            String sql = "select count(*) as num from productos";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("num");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int getNumFactura() {
        try {
            String sql = "select max(idFactura) as num from factura";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("num") + 1;
            } else {
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    public void agregarFactura(int idFactura, String idCliente, Date fecha) {
        try {
            String sql = "insert into factura values("
                    + idFactura
                    + ", '" + idCliente
                    + "', '" + Utilidades.formatDate(fecha) + "')";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarDetalleFactura(
            int idFactura,
            int idLinea,
            String idProducto,
            String descripcion,
            int precio,
            int cantidad) {
        try {
            String sql = "insert into detallefactura values("
                    + idFactura
                    + ", " + idLinea
                    + ", '" + idProducto
                    + "', '" + descripcion
                    + "', " + precio
                    + ", " + cantidad + ")";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambioClave(String usuario, String clave) {
        if (existeUsuario(usuario)) {
            try {
                String sql = "update usuarios set"
                        + " clave = '" + clave
                        + "' where idUsuario = '" + usuario + "'";

                Statement st = cnn.createStatement();
                st.executeUpdate(sql);

            } catch (SQLException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
