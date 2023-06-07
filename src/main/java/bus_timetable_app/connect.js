/*<script>

    document.getElementById("myButton").addEventListener("click", function() {
    fetch("/main.java", {
      method: "POST",
      body: JSON.stringify({}),
      headers: {
        "Content-Type": "application/json"
      }
    })
    .then(response => response.json())
    .then(data => {
      // Handle the response from the Java function
    })
    .catch(error => {
      // Handle errors
    });
  });

</script> */


document.getElementById("myButton").addEventListener("click", function() {
  // Make an AJAX request to the Java backend
  var request = new XMLHttpRequest();
  request.open("GET", "/main.doPost", true);

  request.onreadystatechange = function() {
    if (request.readyState===XMLHttpRequest.DONE && request.status===200) {
      
      var res = request.responseText;
      console.log(res);
    }
    else {
      // Request encountered an error
      console.error("Error: " + xhr.status);
    }
  };

  request.send();
} );

