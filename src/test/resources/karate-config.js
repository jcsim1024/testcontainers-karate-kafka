function fn() {
  karate.configure('connectTimeout', 10000);
  karate.configure('readTimeout', 10000);
  
  var port = karate.properties['server.port'] || '8079';
  var protocol = 'http';
  if (karate.properties['server.protocol'] === 'true') {
    protocol = 'https';
    karate.configure('ssl', true);
  }  
  var config = {
    baseUrl: protocol + '://localhost:' + port ,
    kafbatUiUrl: karate.properties['kafbat-ui.url'] || 'http://kafbat-ui:8080'
  };
  karate.log('karate.env system propertiy was:', karate.env)
  karate.log('karate.config was:', config)


  return config;
}
