package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /**
     * @param json a JSON String
     * @return a {@link Sandwich} object
     * @throws JSONException exception should be caught
     */
    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // constant values for the names of the respective key in the JSON to read
        final String NAME = "name";
        final String MAIN_NAME = "mainName";
        final String ALSO_KNOWN_AS = "alsoKnownAs";
        final String PLACE_OF_ORIGIN = "placeOfOrigin";
        final String DESCRIPTION = "description";
        final String INGREDIENTS = "ingredients";

        // The String is converted to JSONObject for reading
        JSONObject sandwichJsonObject = new JSONObject(json);
        JSONObject nameJsonObject = sandwichJsonObject.getJSONObject(NAME);

        // reading the name of the sandwich
        String mainName = nameJsonObject.getString(MAIN_NAME);

        // reading the alias of the sandwich name
        JSONArray alsoKnownAsArray = nameJsonObject.getJSONArray(ALSO_KNOWN_AS);
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            alsoKnownAs.add(alsoKnownAsArray.getString(i));
        }

        // reading the place of origin
        String placeOfOrigin = sandwichJsonObject.getString(PLACE_OF_ORIGIN);

        // reading the description
        String description = sandwichJsonObject.getString(DESCRIPTION);

        // reading the image
        String image = sandwichJsonObject.getString("image");

        // reading the ingredients
        JSONArray ingredientsArray = sandwichJsonObject.getJSONArray(INGREDIENTS);
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredients.add(ingredientsArray.getString(i));
        }

        // setting the Sandwich properties
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(mainName);
        sandwich.setAlsoKnownAs(alsoKnownAs);
        sandwich.setPlaceOfOrigin(placeOfOrigin);
        sandwich.setDescription(description);
        sandwich.setImage(image);
        sandwich.setIngredients(ingredients);
        return sandwich;
    }
}
