(function($){
	var app = app || {};
	window.app = app;

	app.restUrl = "/api";

	app.ui.MessageList = function($messageList, options) {
		var defaultValues = {visible: true};
		_.defaults(options, defaultValues);

		$messageList.on("click", ".message .close", function(){
			$(this).parent(".message").remove();		
		});
		
		toggle(!this.visible);
		
		var toggle = function(visibility) {
			visibility = visibility || this.visible;

			if (visibility) {
				$messageList.hide();	
			}			
			else {
				loadMessages(function() {
					$messageList.show();
				});
			}				
		}

		var loadMessages = function(loadedCallback) {
			var self = this;

			$.ajax(app.restUrl + "/messages", function(messages){
				var i, message;
				for (i = messages.length; i--;) {
					message = new app.ui.widgets.Message(messages[i]);	
					self.$messageList.append(message.render());
				}

				if (typeof loadedCallback === "function") {
			        	loadedCallback();
				}
			});
		}
		
		return {
			toggle: toggle
		}
	}

	app.ui.widgets = {
		Message: function(text) {
			var render = function() {
				return app.util.renderTemplate("message-template", text);	
			}

			return {
				render: render
			}	
		}	
	};
	
	app.util = {
		renderTemplate: function(templateId, model) {
			if (!templateId) { throw Error("TemplateId is required!") };

			var template = document.getElementById(templateId).textContent;
			return Mustache.to_html(template, model);
		}
	};

	$(document).ready(function(){
		var messageList = new app.ui.MessageList($("#message-list"), {
			visible: false
		});

		$("#menu-item").click(messageList.toggle());
	});
})(window.jquery)
