package lajavel;

import app.Main;
import facade.Log;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    //viewName : name of the Javel file, entries : a map of object -> the object name (person1) and it's associated person obj
    public static String make(String viewName, Map.Entry<String,Object>... entries) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        String rawHtml = View.getViewContentFromName(viewName); //get the HTML
        Matcher matcher = Pattern.compile("\\{\\{(.*?)\\}\\}").matcher(rawHtml); //Find specific content in the HTML
        StringBuffer sb = new StringBuffer(); //will stock content
        while (matcher.find()) { //while regex match proceed
            boolean isMethod = false;
            String rawStringWithoutSpace = matcher.group(1).replaceAll("\\s+", ""); //replace spaces inside {{}}
            String[] objectAndProperty = rawStringWithoutSpace.split("\\."); //get the class before the . and then property after the .
            if(objectAndProperty.length <= 1){
                throw new RuntimeException("you must specify an object and a property in your html");
            }

            String objectName = objectAndProperty[0]; //the object (for example partner)
            String objectProperty = objectAndProperty[1]; //the property (for example name or a method)
            for(Map.Entry<String,Object> entry : entries){
                //if the key (partner for example) matches the objectName above, proceed
                if(entry.getKey().equals(objectName)){
                    //First, It replaces compiled character or word with given input sequence, and
                    // then it appends the given replacement string to the string buffer.
                    matcher.appendReplacement(sb,View.getValueOf(objectProperty,entry.getValue()));
                    break;
                }
            }
        }
        //This method reads the input string and appends it to the given StringBuilder at the tail position.
        matcher.appendTail(sb);
        return sb.toString();
    }
    private static String getViewContentFromName(String viewName) {
        URL resource = Main.class.getClassLoader().getResource("views/"+viewName+".javel");
        if (resource == null) {
            throw new RuntimeException("File : " + viewName +" not found!");
        }
        try{
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.UTF_8);
        } catch(URISyntaxException | IOException e){
            throw new RuntimeException(e);
        }
    }


    public static String getValueOf(String propertyName, Object object){
        boolean isMethod = false;
        String propertyValue;
        if(propertyName.contains("()")){
            isMethod = true;
            propertyName = propertyName.replace("()","");
        }
        if(!isMethod){
            propertyValue = getProperty(object,propertyName);
        }else{
            propertyValue = getMethod(object,propertyName);
        }
        return  propertyValue;
    }
    public static String getMethod(Object obj, String methodName){
        String returnValue = null;
        try{
            Method method = obj.getClass().getMethod(methodName);
            method.setAccessible(true);
            returnValue = method.invoke(obj).toString();
        }
        catch (Exception e){
            //Do nothing, default value
        }
        return returnValue;
    }

    public static String getProperty(Object obj, String property){
        Log.info(obj + " " + property);
        String returnValue = null;
        try{
            Field field = obj.getClass().getDeclaredField(property);
            field.setAccessible(true);
            returnValue = field.get(obj).toString();
        }
        catch (Exception e){
            //Do nothing, default value
        }
        return returnValue;
    }
}
