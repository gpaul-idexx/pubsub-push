Setup a spring boot app running on google app engine to receive push messages from Pubsub in a secure way. (note the admin security-constraint in web.xml)

Run `gradle appEngineDeploy` to deploy it

Set up a topic and subscription pointing to https://<yourapp>.appspot.com/_ah/push-handlers/trial

Then you can publish some stuff, and see the messages at https://<yourapp>.appspot.com/messages