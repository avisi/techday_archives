var logger = (function(console) {
    "use strict";

    var debugEnabled = true, history = [];

    var log = function(fnc, message, args) {
        args = Array.prototype.slice.call(args, 1);
        var currentDate = new Date();
        var formattedTime = util.fullDigit(currentDate.getHours()) + ":" + util.fullDigit(currentDate.getMinutes()) + ":" + util.fullDigit(currentDate.getSeconds());

        var logMessage = "[" + formattedTime + "]" + util.format(message, args);

        console[fnc](logMessage);
        history.push(logMessage);
    };

    var info = function(message) {
        log("log", "[INFO] " + message, arguments);
    };

    var debug = function(message) {
        if (debugEnabled) {
            log("debug", "[DEBUG] " + message, arguments);
        }
    };

    var error = function(message) {
        log("error", "[ERROR] " + message, arguments);
    };

    // Utilities
    var util = {

        format: function(text, args) {
            return text.replace(/{(\d+)}/g, function(match, number) {
                return typeof args[number] !== "undefined" ? args[number] : match;
            });
        },

        fullDigit: function(value) {
            return value < 10 ? "0" + value : value;
        }};

    return {
        info: info,
        debug: debug,
        error: error,

        debugEnabled: debugEnabled,
        history: function() {
            return history.slice(0);
        }
    };
})(window.console);
