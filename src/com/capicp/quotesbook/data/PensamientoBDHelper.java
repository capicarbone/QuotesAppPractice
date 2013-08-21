package com.capicp.quotesbook.data;

import com.capicp.quotesbook.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by capi on 27/06/13.
 */
public class PensamientoBDHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NOMBRE = "pensamientos.db";

    public static final String ID_COLUMNA = "_id";

    public static final String PENSAMIENTOS_NOMBRE_TABLA = "pensamientos";
    public static final String PENSAMIENTOS_COLUMNA_CITA = "cita";
    public static final String PENSAMIENTOS_COLUMNA_AUTOR = "autor_id";

    public static final String AUTORES_NOMBRE_TABLA = "autores";
    public static final String AUTORES_COLUMNA_NOMBRE = "nombre";
    public static final String AUTORES_COLUMNA_DESCRIPCION = "descripcion";
    public static final String AUTORES_COLUMNA_FOTO = "foto";
    public static final String AUTORES_COLUMNA_CATEGORIA = "categoria";

    public static final int CATEGORIA_EMPRENDEDORES = 1;
    public static final int CATEGORIA_LIDERES = 3;
    public static final int CATEGORIA_ESCRITORES = 2;

    public static final String FOTO_JOBS = "steve";
    public static final String FOTO_JOBS_2 = "jobs";
    public static final String FOTO_DORSEY = "dorsey";
    public static final String FOTO_ZUCKERBERG = "zuckerberg";
    public static final String FOTO_GATES = "gates";
    public static final String FOTO_FORD = "ford";
    public static final String FOTO_MANDELA = "mandela";

    public PensamientoBDHelper(Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String autores_tabla_create = "CREATE TABLE " + AUTORES_NOMBRE_TABLA + "( " +
                ID_COLUMNA + " INTEGER PRIMARY KEY, " +
                AUTORES_COLUMNA_NOMBRE + " TEXT, " +
                AUTORES_COLUMNA_DESCRIPCION + " TEXT, " +
                AUTORES_COLUMNA_FOTO + " TEXT, " +
                AUTORES_COLUMNA_CATEGORIA + " INTEGER " +
                ");";

        String pensamientos_tabla_create = "CREATE TABLE " + PENSAMIENTOS_NOMBRE_TABLA + "( " +
                ID_COLUMNA + " INTEGER PRIMARY KEY, " +
                PENSAMIENTOS_COLUMNA_CITA + " TEXT, " +
                PENSAMIENTOS_COLUMNA_AUTOR + " INTEGER, " +
                "FOREIGN KEY(" + PENSAMIENTOS_COLUMNA_AUTOR + ") REFERENCES " + AUTORES_NOMBRE_TABLA + "(" + ID_COLUMNA + "));";

        db.execSQL(autores_tabla_create);
        db.execSQL(pensamientos_tabla_create);

        // Insertando autores

        long id_autor;

        ContentValues content = new ContentValues();
        content.put(AUTORES_COLUMNA_NOMBRE, "Steve Jobs");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Fundador de Apple");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_JOBS_2);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_EMPRENDEDORES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Tu tiempo es limitado, así que no lo malgastes viviendo la vida de otra persona [...] No dejes que el ruido de las opiniones de otros apague tu propia voz interior.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "No puedes preguntarle a los consumidores qué quieren y luego pretender dárselo. En el tiempo que has estado fabricándolo, ellos querrán una cosa nueva.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "No hemos sido los primeros, pero seremos los mejores.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "La innovación no tiene nada que ver con cuánto dinero tiene usted para investigación y desarrollo. Cuando Apple produjo el Mac, IBM estaba gastando al menos cien veces más en esa actividad. No se trata de dinero. Se trata de la gente que usted tiene, de cómo está liderada, y de cuanto logra usted.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Estoy convencido de que la mitad de lo que separa a los emprendedores exitosos de los que no triunfan es la perseverancia");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);


        content.clear();
        content.put(AUTORES_COLUMNA_NOMBRE, "Jack Dorsey");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Fundador de Twitter");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_DORSEY);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_EMPRENDEDORES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "No sé si necesariamente se trate de resolver problemas. Si tienes una idea sobre algo que piensas debería estar en el mundo entonces lo haces, y quizá no resuelva el problema de nadie más sino sólo el tuyo. O tu deseo. Creo que debes ser egoísta en ese sentido. Quiero ver algo en el mundo, y si puedo atraer a más personas a pensar lo mismo, eventualmente crearás un equipo y potencialmente una empresa alrededor de ello. No teníamos que resolver un problema, sino un deseo");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(AUTORES_COLUMNA_NOMBRE, "Mark Zuckerberg");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Fundador de Facebook");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_ZUCKERBERG);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_EMPRENDEDORES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "El mayor riesgo es no correr ningún riesgo. En un mundo que cambia muy rápidamente, la única estrategia que garantiza fallar es no correr riesgos.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "No construimos servicios para hacer el dinero; hacemos el dinero para construir mejores servicios.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Yo pasé mucho tiempo pensando cómo construir esto y no cómo lograr éxito. Yo pienso que esa es la labor más interesante que cualquier otra labor.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(AUTORES_COLUMNA_NOMBRE, "Bill Gates");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Fundador de Microsoft");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_GATES);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_EMPRENDEDORES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Está bien celebrar el éxito, pero es más importante prestar atención a las lecciones del fracaso.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Si piensas que tu profesor es duro, espera a que tengas un jefe. Ese sí que no tendrá vocación de enseñanza ni la paciencia requerida.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "No ganarás 5.000 euros mensuales justo después de salir de la universidad, y no serás vicepresidente de nada hasta que, con tu esfuerzo, te hayas ganado ambos logros.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Antes de que nacieras, tus padres no eran tan aburridos como ahora. Empezaron a serlo al pagar tus cuentas, limpiar tu ropa y escuchar tus quejas . Así que, antes de emprender tu lucha por las selvas vírgenes contaminadas por la generación de tus padres, inicia el camino limpiando las cosas de tu propia vida, empezando por tu habitación.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(AUTORES_COLUMNA_NOMBRE, "Henry Ford");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Fundador de Ford Motors");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_FORD);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_EMPRENDEDORES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "El dinero no cambia al hombre, simplemente lo desenmascara. Si un hombre es naturalmente egoísta, avaro y arrogante, esto se manifiesta con el dinero.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "El verdadero progreso es el que pone la tecnología al alcance de todos.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Los obstáculos son esas cosas espantosas que ves cuando apartas los ojos de tu meta.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Tanto si piensas que puedes, como si piensas que no puedes, estás en lo cierto.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "El secreto de mi éxito está en pagar como si fuera pródigo y en vender como si estuviera en quiebra.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "El fracaso es, a veces, más fructífero que el éxito.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Si hay un secreto del éxito, reside en la capacidad para apreciar el punto de vista del prójimo y ver las cosas desde ese punto de vista así como del propio.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(AUTORES_COLUMNA_NOMBRE, "Nelson Mandela");
        content.put(AUTORES_COLUMNA_DESCRIPCION, "Presidente de Sudáfrica y Premio Nobel de la Paz");
        content.put(AUTORES_COLUMNA_FOTO, FOTO_MANDELA);
        content.put(AUTORES_COLUMNA_CATEGORIA, CATEGORIA_LIDERES);

        id_autor = db.insert(AUTORES_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Después de escalar una montaña muy alta, descubrimos que hay muchas otras montañas por escalar.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Si quieres hacer la paz con tu enemigo tienes que trabajar con él. Entonces se convierte en tu compañero.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "La mayor gloria no es nunca caer, sino levantarse siempre.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

        content.clear();
        content.put(PENSAMIENTOS_COLUMNA_AUTOR, id_autor);
        content.put(PENSAMIENTOS_COLUMNA_CITA, "Nadie nace odiando a otra persona por el color de su piel, o su origen, o su religión.");
        db.insert(PENSAMIENTOS_NOMBRE_TABLA, null, content);

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if (!db.isReadOnly())
            // Se activa el funcionamiento de claves foraneas.
            db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public static int obtenerFoto(String nombre){

        if (FOTO_JOBS.equals(nombre))
            return R.drawable.steve;

        if (FOTO_JOBS_2.equals(nombre))
            return R.drawable.jobs;

        if (FOTO_DORSEY.equals(nombre))
            return R.drawable.dorsey;

        if (FOTO_ZUCKERBERG.equals(nombre))
            return R.drawable.zuckerberg;

        if (FOTO_GATES.equals(nombre))
            return R.drawable.gates;

        if (FOTO_FORD.equals(nombre))
            return R.drawable.ford;

        if (FOTO_MANDELA.equals(nombre))
            return R.drawable.mandela;

         return R.drawable.steve;
    }
}
