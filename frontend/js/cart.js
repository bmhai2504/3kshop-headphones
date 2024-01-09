function getAllCartItem() {
      $.ajax({
            url: "http://localhost:8080/api/cart-item/all",
            beforeSend: function (xhr) {
                  xhr.setRequestHeader('Authorization', "Bearer " + window.localStorage.getItem("token"));
            },
            type: "get",
            dataType: "json",
            crossDomain: true,
            contentType: 'application/json',
            success: (response) => {
                  let content = renderCartItem(response);
                  $("#cartItem").html(content);
            },
            error: (error) => {
                  console.log("aaaaaaa");
                  console.log(error);
            }
      });
}

function renderCartItem(data) {
      data.forEach(item => {
            content +=
                  `
          <tr>
              <td>${item.id}</td>
              <td>${item.productName}</td>
              <td>${item.quantity}</td>
              <td>${item.price}</td>
              <td>${item.price}</td>
              <td>
              <button onclick="editCartItem(${item.id})" type="button" >Edit</button>
              </td>
              <td>
                  <button onclick="deleteCartItem(${item.id})" type="button">Delete</button>
              </td>
          </tr>
  `;
      }
      )
      return content;
}
