Techday-GWT
===========

Get started
-----------

### Install GWT toolkit from Chrome Web Store

#### Chrome

Search for 'GWT'.  
Go to extenstions tab.  
Install 'GWT Developer Plugin'  

#### Firefox

Firefox will ask you to install an extension when you visit the demo applications URL.


### Download and install the project

```
git clone git@github.com:avisi/techday-gwt.git
cd techday-gwt
mvn clean install
```
This may take a while

### Start the server

```
cd gwt-server
mvn package jetty:run
```

### Start the client

```
cd gwt-client
mvn gwt:run
```

Open `http://127.0.0.1:8888/index?gwt.codesvr=127.0.0.1:9997#index` in Chrome.
Because you run in `Dev-mode` GWT will compile your Java code. This takes some a  few seconds.

It is possible to use GWT in Firefox. But you are on your own (with Google).

## Usefull Links

GWT documentatie: `https://developers.google.com/web-toolkit/overview`  
Errai documentatie: `http://docs.jboss.org/errai/2.2.0.Final/errai/reference/html_single/`

 
