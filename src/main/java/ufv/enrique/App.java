package ufv.enrique;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App
{
    public static ArrayList<Amigo> Amigos = new ArrayList<Amigo>();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        escribir();
        lector_json();
        ver_amigos();
    }

    private static void escribir(){
        JSONObject obj1 = new JSONObject();

        JSONArray arrayAmigos = new JSONArray();
        JSONObject obj2 = new JSONObject();
        JSONObject obj3 = new JSONObject();
        JSONObject obj4 = new JSONObject();

        obj2.put("nombre","Fer");
        obj2.put("edad", 21);
        obj2.put("coche", "mercedes refachero");
        arrayAmigos.add(obj2);
        obj1.put("amigos", arrayAmigos);

        obj3.put("nombre","Edu");
        obj3.put("edad", 20);
        obj3.put("coche", "none");
        arrayAmigos.add(obj3);

        obj4.put("nombre","javi");
        obj4.put("edad", 20);
        obj4.put("coche", "azul refachero");
        arrayAmigos.add(obj4);
        obj1.put("amigos", arrayAmigos);

        // Write file
        try(FileWriter file = new FileWriter("amigos.json")){
            file.write(obj1.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void lector_json() {

        JSONParser jsonParser = new JSONParser();

        String Nombre_aux;
        String Coche_aux;
        long Edad_aux;

        try {

            Object obj = jsonParser.parse(new FileReader("amigos.json"));

            JSONObject jsonObject = (JSONObject) obj;

            //seleccionamos el objeto que queremos (En nuestro caso solo es 1 dado que solo tenemos 1 agenda)
            JSONArray Agenda_JSON = (JSONArray) jsonObject.get("amigos");


            // debemos hacer esto si tenemos en el JSON un array que tiene diferentes valores dentro
            Iterator<JSONObject> iterator = Agenda_JSON.iterator();

            while (iterator.hasNext()) {
                Amigo Contacto_aux = new Amigo();
                JSONObject Objeto_aux= iterator.next();
                Contacto_aux.setNombre((String) Objeto_aux.get("nombre"));
                Contacto_aux.setCoche((String) Objeto_aux.get("coche"));
                Contacto_aux.setEdad((long) Objeto_aux.get("edad"));
                Amigos.add(Contacto_aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ver_amigos(){
        for (int i = 0; i < Amigos.size(); i++) {
            System.out.println(i+1 + ". \n" + Amigos.get(i).getNombre());
            System.out.println(Amigos.get(i).getCoche());
            System.out.println(Amigos.get(i).getEdad() + "\n");
        }
    }

}
