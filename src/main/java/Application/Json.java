package Application;

import Exceptions.DoublonException;
import Modele.Abstract.Album;
import Modele.Discotheque;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Json {

public static void remplirJson(ArrayList<Album> liste){
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<ArrayList<Album>> TYPE_LISTE = new TypeReference<>() {};

    mapper.writerFor(TYPE_LISTE).withDefaultPrettyPrinter().writeValue(new File("src/main/resources/disco.json"),liste);

}

public static void lireJson() throws DoublonException {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<Album> albums = mapper.readValue(new File("src/main/resources/disco.json"), new TypeReference<ArrayList<Album>>(){});
    for(Album a : albums){
        Discotheque.ajouterAlbum(a);
    }

}


}
