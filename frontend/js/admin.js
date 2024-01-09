function getProductByPageNumber(pageNumber) {
      $.ajax({
            url: `http://localhost:8080/api/admin/products` + "?page=" + pageNumber,
            dataType: "json",
            success: (result) => {
                  let productList = result.data;
                  console.log(productList);
                  let context = "";
                  productList.forEach(item => {
                        context +=
                              `
                      <tr>
                          <td>${item.id}</td>
                          <td>${item.name}</td>
                          <td>${item.image}</td>
                          <td>${item.price}</td>
                          <td><button onclick="editProduct(${item.id})" type="button" >Edit</button></td>
                          <td>
                              <button onclick="deleteProduct(${item.id})" type="button" >Delete</button>
                          </td>
                          <td>
                            <button onclick="viewDetail(${item.id})" type="button" >View</button>
                          </td>
                      </tr>
              `;
                        let title = "Page" + (pageNumber + 1);
                        let newUrl = "?page=" + (pageNumber + 1);
                        window.history.pushState("Success", title, newUrl);
                        let url = getParamSort();
                        console.log("url is" + url);
                  })
                  $("#productList").html(context);
                  // console.log(result.number, result.totalPages);
                  createPaging(result.pageNumber, result.totalPages);
            }
      });
}

function createPaging(pageNumber, totalPages) {
      let pageCurrent = 0;

      if (pageNumber < totalPages && pageNumber >= 0) {
            pageCurrent = pageNumber + 1;

      } else {
            pageCurrent = pageNumber;
      }
      // console.log(pageCurrent);
      localStorage.setItem("pageCurrent", pageCurrent);

      let pagination =
            `
      <nav aria-label="Page navigation example">
        <ul class="pagination">
      `;

      if (pageCurrent > 1) {
            let pageTemp = parseInt(localStorage.getItem("pageCurrent"));
            pagination +=
                  `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageTemp - 2) + `)">&laquo;</a></li>`;
      }

      if (totalPages < 7) {
            for (let pageNum = 1; pageNum <= totalPages; pageNum++) {
                  pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageNum - 1) + `)">` + pageNum + `</a></li>`;
            }
      } else {
            if (pageCurrent <= 3) {
                  if (pageCurrent == 0) {
                        pageCurrent += 1;
                  }
                  // console.log(pageCurrent);
                  switch (pageCurrent) {
                        case 0: {
                              pagination += `<li class="page-item active"><a class="page-link" onclick="getProductByPageNumber(${(pageCurrent - 1)})">${pageCurrent}</a></li>`;
                              // pagination += `<li class="page-item active"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 1) + `)">` + pageCurrent + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent) + `)">` + (pageCurrent + 1) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent + 1) + `)">` + (pageCurrent + 2) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent + 2) + `)">` + (pageCurrent + 3) + `</a></li>`;
                              break;
                        }
                        case 1: {
                              pagination += `<li class="page-item active"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 1) + `)">` + pageCurrent + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent) + `)">` + (pageCurrent + 1) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent + 1) + `)">` + (pageCurrent + 2) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent + 2) + `)">` + (pageCurrent + 3) + `</a></li>`;
                              break;
                        }
                        case 2: {
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 2) + `)">` + (pageCurrent - 1) + `</a></li>`;
                              pagination += `<li class="page-item active"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 1) + `)">` + pageCurrent + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + pageCurrent + `)">` + (pageCurrent + 1) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent + 1) + `)">` + (pageCurrent + 2) + `</a></li>`;
                              break;
                        }
                        case 3: {
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 3) + `)">` + (pageCurrent - 2) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 2) + `)">` + (pageCurrent - 1) + `</a></li>`;
                              pagination += `<li class="page-item active"><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 1) + `)">` + (pageCurrent) + `</a></li>`;
                              pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + pageCurrent + `)">` + (pageCurrent + 1) + `</a></li>`;
                              break;
                        }
                  }
                  pagination += `<li class="page-item"><a class="page-link" ">` + '...' + `</a></li>`;
            } else {
                  pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(0)">` + 1 + `</a></li>`;
                  pagination += `<li class="page-item"><a class="page-link" ">...</a></li>`;

                  if (pageCurrent <= totalPages) {
                        if (pageCurrent >= totalPages - 1) {
                              if (pageCurrent == totalPages) {
                                    pagination += `<li class="page-item "><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 4) + `)">` + (pageCurrent - 3) + `</a></li>`;
                              }
                              pagination += `<li class="page-item "><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 3) + `)">` + (pageCurrent - 2) + `</a></li>`;
                        }
                        pagination += `<li class="page-item "><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent - 2) + `)">` + (pageCurrent - 1) + `</a></li>`;
                        pagination += `<li class="page-item active"><a class="page-link " onclick="getProductByPageNumber(` + (pageCurrent - 1) + `)" >` + pageCurrent + `</a></li>`;
                        if (pageCurrent < totalPages)
                              pagination += `<li class="page-item "><a class="page-link" onclick="getProductByPageNumber(` + (pageCurrent) + `)">` + (pageCurrent + 1) + `</a></li>`;


                        if (pageCurrent < (totalPages - 2)) {
                              pagination += `<li class="page-item"><a class="page-link" ">...</a></li>`;
                        }
                  }
            }
            if (pageCurrent < totalPages - 1) {
                  pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (totalPages - 1) + `)">` + totalPages + `</a></li>`;
            }

      }
      if (pageCurrent < totalPages) {
            let pageTemp = parseInt(localStorage.getItem("pageCurrent"));
            pagination += `<li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + pageTemp + `)">&raquo;</a></li>`;
            // pagination += ` <li class="page-item"><a class="page-link" onclick="getProductByPageNumber(` + (localStorage.getItem("pageCurrent") + 1) + `)">&raquo;</a></li>`;
      }
      pagination += `</ul>
       </nav>`;
      // let pagination = "";

      $("#showPagination").html(pagination);

}

function deleteProduct(id) {
      $.ajax({
            url: "http://localhost:8080/api/admin/product/" + id,
            type: "delete",
            dataType: "json",
            success: (result) => {
                  if (result) {
                        $("#messageDelete").html("Xoa San Pham Thanh Cong");
                        window.location.href = "http://127.0.0.1:5500/html/admin.htmlml";
                        // renderProduct();
                  } else {
                        history.go(0);
                        $("#messageDelete").html("Xoa San Pham Khong Thanh Cong");
                  }
            },
            error: (e) => {
                  console.log(e);
            }
      })
}
function getParamSort() {
      if (window.location.href.search("\\?") < 0) {
        return null;
      } else {
        let temp = window.location.href.split("?");
        let tempAnd = temp[1].split("&");
        console.log("tempAnd is " + tempAnd);
        let requestParam = [];
        let array;
        for (let i = 0; i < tempAnd.length; i++) {
          array = tempAnd[i].split("=");
          for (let i = 0; i < array.length; i++) {
            requestParam.push(array[i]);
          }
        }
        console.log("array is" + array);
        console.log("requestParam is " + requestParam);
        return requestParam;
      }
    
    }
    
    
    
    
    
    
    
    
    
    