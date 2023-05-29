function carrega(){
  var tipoProdutoImagem = {
    "1": "carneCibus.jpeg",
    "2": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGaPi8h90zwWe7NpANKEVlab60J616-fuMhA&usqp=CAU",
    "3": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTh2FlUrmlOC6o851wvHIsxZgXH6x631ivdMw&usqp=CAU",
    "4": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHL2DfP2nunLjC2eE5n5cWfDeKpdXcwV8xtg&usqp=CAU",
    "5": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8yFntWlHoSUGvhR03ZXlCAocYcvdMFnBqYQ&usqp=CAU",
    "6": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZXe7qmJgRwEemsi7UC7M7DuAnKtZPES2dLA&usqp=CAU",
    "7": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIR8yLU-7SQnBY2T0mqr17zx_itlpniOC2qA&usqp=CAU",
    "8": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm88Y50LtvXNTs309Lyl6RzIp-0q17332utmF2w_4YMwgXWRspjXjkMQQLXbAAvloFQ6E&usqp=CAU",
    "9": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7EP7JmsSotNZolIOdWIulpimMr3Xj2hybhQ&usqp=CAU",
    "10": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRc4hO8peXanBRu5Uh7fGGuWC_fcBX_MNL2zA&usqp=CAU",
    "11": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9znUBDf1NCe7uWs6oLh48o23JWZYSZTv_Dg&usqp=CAU",
    "12": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYo2nC9JdrfgGi26ZJ1wEYp4PrOPLZAqpcLg&usqp=CAU",
    "13": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIB-8y4Dqe_VUQnDXjvSml-1M0yOADbt92AQ&usqp=CAU",
    "14": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXWzxOGDGUj6E7QA6Iu-OJ5l4vhD5MhasxUQ&usqp=CAU",
    "15": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhgwtUaSotBE03wHocNJ1dJJCjDHRV-z4Omg&usqp=CAU",
    "16": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7LGVUgAoqgH_iUEvL9jMkN_sWIBUWaVEiDQ&usqp=CAU",
    "17": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3DrCnULY07iqW1i8231TGp9dbDm4VxJpp-A&usqp=CAU",
    "18": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-8vm176Eg35HRLgsDnTuItXnV0ACV-JweEA&usqp=CAU",
    "19": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt3eM4VEw6x1biEM1RnSAPw1wwiDjP-cJY_Q&usqp=CAU"
  }
  ;  
  let url =`/all`
    fetch(url)
    .then (res=>res.json())
    .then (data =>{
      let str = ''
          console.log(data)
          for (let i = 0; i < data.length; i++) {
            let oferta=data[i];
            let imagem;
            console.log(oferta.tipoProduto)
            console.log(tipoProdutoImagem[oferta.tipoProduto - 1])
            if(oferta.tipoProduto == tipoProdutoImagem[oferta.tipoProduto - 1]){
              imagem = tipoProdutoImagem[oferta.tipoProduto - 1];
            }else{
              imagem = "default";
            }
            str += ` 
            <div class="card">
                <img src="${imagem}" alt="Imagem do Produto" class="product-image">
                <h2 class="product-name">${oferta.descricao}</h2>
                <p class="product-price">${oferta.preco}</p>
                <p class="product-supermercado">${oferta.codSupermercado}</p>
            </div>
        `
          
        }
          document.getElementById('tela').innerHTML = str;
});
}
 carrega();


