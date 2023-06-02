//document.getElementById("akuika-btn").onclick= 
/* function insere(){

    console.log("chamou a requisição")
    let descricao = document.getElementById("oferta-arquivo").value;
    let codSupermercado = document.getElementById("supermercado-id").value;
      
    let url = `/lerArquivo/?codSupermercado=${codSupermercado}&nomeDoArquivo=${descricao}`;
    fetch(url, { method: 'POST' })
    .then(window.location.href = "escolher.html")}
 */
//document.getElementById("akuika-btn").addEventListener("click", insere());
//document.getElementById("update-btn").onclick= async function insere();


document.getElementById("cadastro-btn").addEventListener("click", insere())

function insere(){

    console.log("chamou a requisição")
    urlParams=new URLSearchParams(window.location.search);
      let descricao = document.getElementById('oferta-arquivo').value;
      console.log(descricao);
     let codSupermercado = document.getElementById('supermercado-id').value;
      console.log(codSupermercado);
    let url = `/lerArquivo/?codSupermercado=${codSupermercado}&nomeDoArquivo=${descricao}`;
  fetch(url, { method: "POST" }).then(console.log("acabou a requisição"))
}
  //document.getElementById("akuika-btn").addEventListener("click", insere());
  //window.location.href = "escolher.html"