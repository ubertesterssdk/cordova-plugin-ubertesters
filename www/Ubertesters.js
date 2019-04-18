
var exec = require('cordova/exec');
var PLUGIN_NAME = 'UbertestersCordova';
var UbertesterAndroid = {
initialize: function(successCallback, failureCallback, args) {
		func = window.onerror;
		window.onerror = function (errorMsg, url, lineNumber) {
			if(func != null){
				func(errorMsg, url, lineNumber)
			}
			errorStr = 'Error2: ' + errorMsg + ' Script: ' + url + ' Line: ' + lineNumber;
			exec(null, null, PLUGIN_NAME, "logError", [errorStr]);
		}
		exec(null, null, PLUGIN_NAME, "initialize", args != null? args: []);
	},

	showUtPage: function(successCallback, failureCallback) {
		exec(null, null, PLUGIN_NAME, "showUtPage", []);	
	},
	hideUtPage: function(successCallback, failureCallback) {
		exec(null, null, PLUGIN_NAME, "hideUtPage", []);	
	},
	takeScreenshot: function(successCallback, failureCallback) {
		exec(null, null, PLUGIN_NAME, "takeScreenshot", []);	
	},
	logInfo: function(successCallback, failureCallback, info) {
		exec(null, null, PLUGIN_NAME, "logInfo", [info]);	
	},	
	logError: function(successCallback, failureCallback, error) {
		exec(null, null, PLUGIN_NAME, "logError", [error]);	
	},	
	logWarn: function(successCallback, failureCallback, warn) {
		exec(null, null, PLUGIN_NAME, "logWarn", [warn]);	
	}	
};

module.exports = UbertesterAndroid;


