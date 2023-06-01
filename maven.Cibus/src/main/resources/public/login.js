  document.addEventListener('DOMContentLoaded', function() {
    var loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', function(event) {
      event.preventDefault(); // Evita o envio do formulário padrão

      var username = document.getElementById('username').value;
      var password = document.getElementById('password').value;

      // Verifique as credenciais do usuário no banco de dados (substitua com seu código real)
      var validCredentials = checkCredentials(username, password);

      if (validCredentials) {
        // Redirecione o usuário para a página "escolher.html"
        window.location.href = 'escolher.html';
      } else {
        // Exiba uma mensagem de erro ou tome outra ação adequada
        alert('Credenciais inválidas. Tente novamente.');
      }
    });

    // Função de exemplo para verificar as credenciais do usuário
    function checkCredentials(username, password) {
      // Substitua com seu código real de verificação das credenciais do usuário
      // Consulte o banco de dados ou faça outra validação necessária

      // Exemplo de verificação simples (usuário: "admin", senha: "123456")
      if (username === 'admin' && password === '123456') {
        return true;
      } else {
        return false;
      }
    }
  });

