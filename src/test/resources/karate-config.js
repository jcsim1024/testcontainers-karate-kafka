function fn() {
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  
  var port = karate.properties['server.port'] || '8080';
  var protocol = 'http';
  if (karate.properties['server.protocol'] === 'true') {
    protocol = 'https';
    karate.configure('ssl', true);
  }  
  var config = { baseUrl: protocol + '://localhost:' + port };
  
  return config;
}