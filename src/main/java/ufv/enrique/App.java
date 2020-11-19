package ufv.enrique;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        escribir();
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
}
