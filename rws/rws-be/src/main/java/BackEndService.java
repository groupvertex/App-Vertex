/**
 * Created by user on 19.06.2016.
 */

import entity.Route;
import org.json.simple.JSONObject;


public class BackEndService {

    public String getRouteInfo(Route route) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", route.getId());
        jsonObj.put("name", route.getName());
        jsonObj.put("wayPoints", route.getWayPoints());
        return jsonObj.toString();

    }


}
