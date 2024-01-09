

function renderProduct(productList) {
      let content = "";
      productList.forEach(product => {
            content += `
                        <div class="card" style="width: 18rem; height: 30rem; margin-bottom: 20px;">
                              <div style="height: 65%; width: 100%;">
                                    <img src="${product.image}" class="card-img-top" alt="${product.name}" >
                              </div>
                              
                              <hr>
                              <div class="card-body " style="height: 35%; width: 100%;">
                                    <p class="card-text" style="height: 25%;">${product.name}</p>
                                    <p  class="card-text" style="height: 20%;" margin>Giá : ${product.price} đ</p>
                                    
                                    <button style="height: 30%;" class="btn btn-primary btn-rounded btn-floating"  type="button" onclick="addCartItem(${product.id})">Add To Cart</button>         
                              </div>
                        </div> 
                        `
      })
      return content;
}

function getTypeByCategoryID(categoryID) {
      $("#typeProduct").empty();
      $("#typeProducts").show();
      $.ajax(
            {
                  url: `http://localhost:8080/api/category/${categoryID}/types`,
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = "";
                        data.forEach(type => {
                              content += `
                        <li>
                              <button class="nav-link btn btn-primary text-dark" onclick="showProductByTypeID(${type.id})">${type.name}</button>
                        </li>
                        `
                        })
                        $("#typeProduct").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function getAllCategory() {
      $("#categoryProduct").empty();
      $.ajax(
            {
                  url: "http://localhost:8080/api/category",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = "";
                        data.forEach(category => {
                              content += `
                        <li>
                              <button class="nav-link btn btn-primary text-dark" onclick="showProductByCategoryID(${category.id})">${category.name}</button>
                        </li>
                        `
                        })
                        $("#categoryProduct").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function showProductByCategoryID(categoryID) {
      getTypeByCategoryID(categoryID);
      $("#product").empty();
      $.ajax(
            {
                  url: `http://localhost:8080/api/category/${categoryID}/products`,
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = renderProduct(data);
                        localStorage.setItem("url", `http://localhost:8080/api/category/${categoryID}/products`);
                        $("#product").html(content);

                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function getBrandNavBar() {
      $("#brandProduct").empty();
      $.ajax(
            {
                  url: "http://localhost:8080/api/brand/navbar",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = "";
                        data.forEach(brand => {
                              content += `
                        <li>
                              <a class="dropdown-item" href="#">
                                    <img class="img-nav" src="${brand.image}" alt="${brand.name}">
                              </a>
                        </li> 
                        `
                        })
                        $("#brandProduct").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function getAllBrands() {
      $("#allBrands").empty();
      $.ajax(
            {
                  url: "http://localhost:8080/api/brand/all",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        console.log(data);
                        let content = "";
                        data.forEach(brand => {
                              content += `
                              <li>
                                    <a class="nav-link btn btn-primary text-dark " onclick ="showProductByBrandID(${brand.id})" >${brand.name}</a>
                              </li>
                        
                        `
                        })
                        $("#allBrands").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function getProductRecommend() {
      $("#productRecommendation").empty();
      $.ajax(
            {
                  url: "http://localhost:8080/api/product/recommendation",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = "";
                        data.forEach(product => {
                              content += `
                        <div class="card" style="width: 18rem;">
                              <div style="height: 70%; width: 100%;">
                                    <img src="${product.image}" class="card-img-top" alt="${product.name}" >
                              </div>
                              
                              <hr>
                              <div class="card-body " style="height: 30%; width: 100%;">
                                    <p class="card-text">${product.name}</p>
                                    <p  class="card-text">Giá : ${product.price} đ</p>
                                    <div style="height: 0%;">
                                          <button class="btn btn-primary btn-rounded btn-floating"  type="button" onclick="addCartItem(${product.id})">Add To Cart</button>
                                    </div>
                                   
                              </div>
                        </div> 
                        `
                        })

                        $("#productRecommendation").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function getAllProduct() {
      $("#product").empty();
      $.ajax(
            {
                  url: "http://localhost:8080/api/product/all",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = renderProduct(data);
                        localStorage.setItem("url", "http://localhost:8080/api/product/all");
                        $("#product").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function goToProductPage() {
      window.location.href = "http://127.0.0.1:5500/html/products.html";
}

function showProductByBrandID(brandID) {

}

function ascending() {
      let urlTemp = localStorage.getItem("url");
      $("#product").empty();
      // console.log(urlTemp + "?sort=price&order=desc");
      $.ajax(
            {
                  url: urlTemp + "/sort?sort=price&order=asc",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = renderProduct(data);
                        $("#product").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function descending() {
      let urlTemp = localStorage.getItem("url");
      $("#product").empty();
      // console.log(urlTemp + "?sort=price&order=desc");
      $.ajax(
            {
                  url: urlTemp + "/sort?sort=price&order=desc",
                  type: "GET",
                  dataType: "json",
                  success: (response) => {
                        let data = response.data;
                        let content = renderProduct(data);
                        $("#product").html(content);
                  },
                  error: (error) => {
                        console.log(error);
                  }
            }
      )
}

function addToCartCounter() {
      if (localStorage.clickcount) {
            localStorage.clickcount = Number(localStorage.clickcount) + 1;
      } else {
            localStorage.clickcount = 1;
      }
      document.getElementById("countCartItem").innerHTML = localStorage.clickcount;
}

function logout() {
      localStorage.removeItem("token");
      localStorage.removeItem("name");
      localStorage.removeItem("clickcount");
      window.location.href = "http://127.0.0.1:5500/html/index.html";
}

function search() {
      let text = $("#searchProduct").val();
      console.log(text);
      let urltemp = "http://localhost:8080/api/product/search?search=" + text + "&sort=price&order=asc";
      $.ajax({
            url: urltemp,
            dataType: "json",
            type: "get",
            success: (response) => {
                  let data = response.data;
                  console.log(data);
                  let content = renderProduct(data);
                  // localStorage.setItem("url", urltemp);
                  $("#product").html(content);
            },
            error: (error) => {
                  console.log(error);
            }
      })
}

function addCartItem(productID) {
      let jwt = "Bearer " + window.localStorage.getItem("token");
      console.log(jwt);
      if(jwt != null){
            $.ajax({
                  // headers: {
                  //       // "Content-Type": "application/x-www-form-urlencoded",
                  //     "Authorization": `Bearer` + window.localStorage.getItem("token")
                  // },
                   // headers: {
                  //     "Authorization": `Bearer` + window.localStorage.getItem("token")
                  // },
                  url: "http://localhost:8080/api/cart-item/product/" + productID,
                  beforeSend: function (xhr){ 
                        xhr.setRequestHeader('Authorization', "Bearer " + window.localStorage.getItem("token")); 
                    },
                  type: "put",                  
                  dataType: "json",
                  crossDomain: true,
                  contentType: 'application/json',
                  success: (response) => {
                        console.log(response);
                      alert("Add To Cart Success !!!");
                  },
                  error: (error) => {
                      console.log("aaaaaaa");
                      console.log(error);
                  }
              })
      }
     
}

function showCartItem(){
      window.location.href = "http://127.0.0.1:5500/html/cart.html"
}