package cordova.plugin.ubertesters;

import android.app.Application;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class UbertestersCordova extends CordovaPlugin {

    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        PluginResult result = new PluginResult(PluginResult.Status.ERROR);
        if (action.equals("showUtPage")) { // Show Menu Manual
            Ubertesters.showMenu();
            callbackContext.success();
            return true;
        } else if (action.equals("hideUtPage")) { // Hide Menu Manual
            Ubertesters.hideMenu();
            callbackContext.success();
            return true;
        } else if (action.equals("takeScreenshot")) { // Take Screen Shot
            Ubertesters.takeScreenshot();
            callbackContext.success();
            return true;
        } else if (action.equals("logInfo")) { //Log info for UberTester server
            String message = args.getString(0);
            Ubertesters.logger().info(message);
            callbackContext.success();
            return true;
        } else if (action.equals("logError")) { ///Log Error for UberTester server
            String message = args.getString(0);
            Ubertesters.logger().error(message);
            callbackContext.success();
            return true;
        } else if (action.equals("logWarn")) { ////Log Warning for UberTester server
            String message = args.getString(0);
            Ubertesters.logger().warn(message);
            callbackContext.success();
            return true;
        }

        callbackContext.sendPluginResult(result);
        return false;
    }
}
