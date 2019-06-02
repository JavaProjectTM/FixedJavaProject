function SearchFunction() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");
  

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
function SearchFunctionVertrekTijd() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInputVertrekTijd");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
function SearchFunctionAankomstTijd() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInputAankomstTijd");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[3];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

function SearchFunction1() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput1");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[4];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
function SearchFunction2() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput2");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
function SearchFunction3() {
   
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput3");
  filter = input.value.toUpperCase();
  table = document.getElementById("#VluchtTable");
  tr = table.getElementsByTagName("tr");

  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[6];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

