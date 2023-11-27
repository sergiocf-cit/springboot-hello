const http = require('http');

const url = 'http://20.124.148.108/gt/performance?loop=100000';

function makeRequest() {
  http.get(url, (response) => {
    let data = '';

    // A chunk of data has been received.
    response.on('data', (chunk) => {
      data += chunk;
    });

    // The whole response has been received.
    response.on('end', () => {
      console.log(data);
    });
  }).on('error', (error) => {
    console.error(`Error making HTTP request: ${error.message}`);
  });
}

// Make an initial request
makeRequest();

// Set up interval to make requests every 1 second
setInterval(makeRequest, 100);
