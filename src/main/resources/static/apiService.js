// Corrigido o nome 'documents' para 'document' e corrigidos os seletores.
const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const nomeInput = document.querySelector("input[name='nome']");
const enderecoInput = document.querySelector("input[name='endereco']");
const telefoneInput = document.querySelector("input[name='telefone']");
const emailInput = document.querySelector("input[name='email']");

// Função para enviar os dados do formulário
function cadastrar() {
    fetch("http://localhost:8080/cadastro", {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            nome: nomeInput.value,
            endereco: enderecoInput.value,
            telefone: telefoneInput.value,
            email: emailInput.value
        })
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Erro na requisição');
        }
    })
    .then(data => {
        console.log('Cadastro realizado com sucesso:', data);
        // Aqui você pode adicionar lógica para lidar com a resposta do servidor
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}

// Adiciona um listener ao botão para chamar a função de cadastro ao ser clicado
botao.addEventListener('click', (event) => {
    event.preventDefault(); // Previne o comportamento padrão do formulário
    cadastrar();
});
