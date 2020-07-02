// perform a GET to the endpoint
// https://happyreturnsqatest.free.beeceptor.com/getProductVariants

// Map a variant object from the variants array from the GET to a JSON object
/* store the data from the variant and convert it to JSON */

// Perform a POST using the object as the request body to the endpoint:
// https://happyreturnsqatest.free.beeceptor.com/order
/* Create a POST request using the converted data as the body  */

// Using AJAX

function getRequest(url) {
  const http = new XMLHttpRequest();

  http.open("GET", url);

  http.onreadystatechange = (e) => {
    // see what the response looks like first
    // when an event occurs
    console.log(http.responseText);
  };
}

getRequest("https://happyreturnsqatest.free.beeceptor.com/getProductVariants");
// save the response text and convert it to JSON
