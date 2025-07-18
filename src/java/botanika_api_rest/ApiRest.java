package botanika_api_rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import botanika_models.Cita;
import botanika_models.Cotizacion;
import botanika_models.Estado_cita;
import botanika_models.Mensaje;
import botanika_models.Orden;
import botanika_models.Rol;
import botanika_models.Mensaje;
import botanika_models.Producto;
import botanika_models.Orden_producto;
import botanika_models.Usuario;

import botanika_controller.ControllerCita;
import botanika_controller.ControllerCotizacion;
import botanika_controller.ControllerProducto;
import botanika_controller.ControllerEstadoCita;
import botanika_controller.ControllerMensaje;
import botanika_controller.ControllerOrden;
import botanika_controller.ControllerRol;
import botanika_controller.ControllerMensaje;
import botanika_controller.ControllerOrdenProducto;
import botanika_controller.ControllerUsuario;

@Path("apirest")
public class ApiRest {

    private final Gson gson = new Gson();

    private Response error(String mensaje) {
        String out = "{\"error\":\"" + mensaje + "\"}";
        return Response.status(Response.Status.BAD_REQUEST).entity(out).build();
    }

    @POST
    @Path("insertar_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response altaUsuario(@FormParam("datosUsuario") @DefaultValue("") String datosUsuario) {
        String out;
        try {
            Usuario usuario = gson.fromJson(datosUsuario, Usuario.class);
            if (usuario == null || usuario.getNombre() == null) {
                throw new JsonParseException("Usuario nulo");
            }
            if (usuario.getId() > 0) {
                return error("El campo 'id' debe ser 0 o ausente para una alta.");
            }
            ControllerUsuario controller = new ControllerUsuario();
            controller.insertarUsuario(usuario);
            out = gson.toJson(usuario);
        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor. Intente más tarde.");
        }
        return Response.ok(out).build();
    }

    @POST
    @Path("modificar_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarUsuario(@FormParam("datosUsuario")
            @DefaultValue("") String json) {
        String out;

        try {
            Usuario usuario = gson.fromJson(json, Usuario.class
            );

            if (usuario.getId() <= 0) {
                return error("Se requiere un ID válido para modificar.");
            }

            new ControllerUsuario().modificarUsuario(usuario);

            out = gson.toJson(usuario);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor.");
        }

        return Response.ok(out).build();
    }

    @POST
    @Path("eliminar_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarUsuario(@FormParam("datosUsuario")
            @DefaultValue("") String json) {
        String out;

        try {
            Usuario usuario = gson.fromJson(json, Usuario.class
            );

            if (usuario.getId() <= 0) {
                return error("ID de empleado inválido para eliminar.");
            }

            String mensaje = new ControllerUsuario().eliminarUsuario(usuario);
            out = "{\"mensaje\":\"" + mensaje + "\"}";

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor.");
        }

        return Response.ok(out).build();
    }

    @Path("get_all_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllusuario(@QueryParam("filtro")
            @DefaultValue("") String filtro) {
        List<Usuario> usuarios;
        ControllerUsuario cu = new ControllerUsuario();
        try {
            usuarios = cu.getAll();
            String out = new Gson().toJson(usuarios);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"error\":\"Error en el servidor\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorJson)
                    .build();
        }
    }
    @POST
    @Path("insertar_producto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response altaProducto(@FormParam("datosProducto") @DefaultValue("") String datosProducto) {
        String out;
        try {
            Producto producto = gson.fromJson(datosProducto, Producto.class);
            if (producto == null || producto.getNombre() == null) {
                throw new JsonParseException("Producto nulo");
            }
            if (producto.getId() > 0) {
                return error("El campo 'id' debe ser 0 o ausente para una alta.");
            }
            ControllerProducto controller = new ControllerProducto();
            controller.insertarProducto(producto);
            out = gson.toJson(producto);
        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor. Intente más tarde.");
        }
        return Response.ok(out).build();
    }

    @POST
    @Path("modificar_producto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarProducto(@FormParam("datosProducto")
            @DefaultValue("") String json) {
        String out;

        try {
            Producto producto = gson.fromJson(json, Producto.class
            );

            if (producto.getId() <= 0) {
                return error("Se requiere un ID válido para modificar.");
            }

            new ControllerProducto().modificarProducto(producto);

            out = gson.toJson(producto);

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor.");
        }

        return Response.ok(out).build();
    }

    @POST
    @Path("eliminar_producto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProducto(@FormParam("datosProducto")
            @DefaultValue("") String json) {
        String out;

        try {
            Producto producto = gson.fromJson(json, Producto.class
            );

            if (producto.getId() <= 0) {
                return error("ID de empleado inválido para eliminar.");
            }

            String mensaje = new ControllerProducto().eliminarProducto(producto);
            out = "{\"mensaje\":\"" + mensaje + "\"}";

        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            return error("Formato de datos no válido.");
        } catch (Exception e) {
            e.printStackTrace();
            return error("Error interno del servidor.");
        }

        return Response.ok(out).build();
    }

    

    @Path("get_all_rol")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllRol(@QueryParam("filtro")
            @DefaultValue("") String filtro) {
        List<Rol> rols;
        ControllerRol cu = new ControllerRol();
        try {
            rols = cu.getAll();
            String out = new Gson().toJson(rols);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"error\":\"Error en el servidor\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorJson)
                    .build();
        }
    }

    @Path("get_all_estado_cita")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllEstadoCita(@QueryParam("filtro")
            @DefaultValue("") String filtro) {
        List<Estado_cita> es;
        ControllerEstadoCita cu = new ControllerEstadoCita();
        try {
            es = cu.getAll();
            String out = new Gson().toJson(es);
            return Response.status(Response.Status.OK).entity(out).build();
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"error\":\"Error en el servidor\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorJson)
                    .build();
        }
    }

}
