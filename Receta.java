import java.util.Set;
import java.util.TreeSet;

/**
 * La clase Receta modela una receta para preparar pociones
 * magicas.
 *
 * Se la inicializa con un nombre a eleccion y en estado "ok"
 * en falso.
 *
 * Se deben agregar uno a uno los ingredientes que la conforman.
 * Al terminar la carga, se la establece con "ok" en verdadero.
 *
 * No se puede usar una receta sin terminar.
 *
 * No se pueden agregar ingredientes a una receta terminada.
 */
public class Receta {
    private Boolean cerrada;
    private Set<String> ingredientes;
    private String nombre;

    /**
     * El constructor debe inicializar el objeto con un nombre
     * a eleccion y estado "ok" en falso.
     *
     * No olvidar construir el conjunto (TreeSet) de ingredientes
     *
     * @param nombre El nombre de la receta.
     */
    public Receta (String nombre) {
        // TODO - Implementar metodo
        this.nombre=nombre;
        this.cerrada=false;
        //cerrarReceta();
        this.ingredientes=new TreeSet<String>();

    }

    /**
     * Agrega un nuevo ingrediente a la receta.
     *
     * Solo se aceptaran nuevos ingredientes cuando la
     * receta se encuentre sin terminar ("cerrada" en falso).
     *
     * @param ingrediente El ingrediente a agregar.
     */
    public void addIngrediente(String ingrediente) {
        // TODO - Implementar metodo
        if(!isCerrada()){
            this.ingredientes.add(ingrediente);
        }
    }

    /**
     * Devuelve la cantidad de ingredientes de la receta.
     *
     * @return La cantidad de ingredientes de la receta.
     */
    public int getCantidadIngredientes () {
        // TODO - Implementar metodo
        return this.ingredientes.size();
    }

    /**
     * Devuelve los ingredientes de la receta.
     *
     * @return Los ingredientes de la receta como conjunto.
     */
    public Set<String> getIngredientes () {
        return ingredientes;
    }

    /**
     * Cambia el estado de la receta cuando tenga al menos dos (2) ingredientes.
     * En caso contrario, no hace nada.
     *
     * No puede revertirse.
     *
     * @return true si se pudo cerrar la receta, false en caso contrario
     */
    public Boolean cerrarReceta () {
        // TODO - Implementar metodo
        if(this.getCantidadIngredientes()>=2){
            this.cerrada=true;
            return true;
        }
        else{
            this.cerrada=false;
            return false;
        }
    }


    /**
     * Genera una cadena con la informacion sobre la receta.
     *
     * Debe generarse usando el nombre, "incompleta" o "completa" segun
     * el estado ("ok") y listar los ingredientes que la conforman con el
     * formato
     *     "Receta <nombre> (<estado>)\nIngredientes:\n<ingr1>\n<ingr2>\n..."
     *
     * Ejemplo receta incompleta:
     *    "Receta voladora (incompleta)
     *     Ingredientes:
     *     Pluma"
     *
     * Ejemplo receta completa:
     *    "Receta voladora (completa)
     *     Ingredientes:
     *     Hueso
     *     Pluma
     *     Sangre"
     *
     * @return El texto indicado en el ejemplo.
     */
    @Override
    public String toString() {
        String str="Receta ";
        str+=this.getNombre();
        if(isCerrada()){
            str+=" (completa)\n";
        }
        else{
            str+=" (incompleta)\n";
        }
        str+="Ingredientes:\n";

        for (String ingrediente:getIngredientes()
        ) {
            str+=ingrediente+"\n";
        }



        return str;
    }

    /**
     * Verifica si la receta se puede usar.
     *
     * @return true si puede usarse y false si no esta cargada completamente.
     */
    public Boolean isCerrada () {
        return cerrada;
    }

    public String getNombre () {
        return nombre;
    }

}