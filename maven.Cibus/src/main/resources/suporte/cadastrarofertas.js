function insere(){

    console.log("chamou a requisição")
    //urlParams=new URLSearchParams(window.location.search);
      let descricao = document.getElementById('oferta-arquivo').value;
      console.log(descricao);
     let codSupermercado = document.getElementById('supermercado-id').value;
      console.log(codSupermercado);
     // let descricao=urlParams.get('oferta-arquivo');
      //let codSupermercado=urlParams.get('supermercado-id');

    let url = `/lerArquivo/?codSupermercado=${codSupermercado}&nomeDoArquivo=${descricao}`;
  fetch(url, { method: "POST" }).then(terminou=>{alert("arquivo cadastrado");
  window.location.href="escolher.html";
  }
  )
}