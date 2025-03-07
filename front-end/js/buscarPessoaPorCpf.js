async function buscarPessoaPorCpf() {
    const cpf = prompt("Digite o CPF da Pessoa Física:");
    if (!cpf) return;

    const cpfCodificado = encodeURIComponent(cpf);

    try {
        const response = await fetch(`http://localhost:8080/api/pessoas-fisicas/${cpfCodificado}`);
        if (!response.ok) {
            throw new Error("Erro ao buscar pessoas");
        }

        const respostaJson = await response.json();
        console.log("Resposta da API:", respostaJson); // Log para debug

        // Verifica se a resposta é um array
        const pessoas = Array.isArray(respostaJson) ? respostaJson : [respostaJson];

        if (pessoas.length === 0) {
            alert("Nenhuma pessoa encontrada.");
            return;
        }

        // Exibir o modal e preencher a lista
        const modal = document.getElementById("modalPessoa");
        const lista = document.getElementById("listaPessoas");

        lista.innerHTML = ""; // Limpar lista anterior
        pessoas.forEach((pessoa) => {
            const li = document.createElement("li");
            li.textContent = pessoa.nome;
            li.onclick = () => selecionarPessoa(pessoa);
            lista.appendChild(li);
        });

        modal.style.display = "flex"; // Exibir modal
    } catch (error) {
        console.error("Erro ao buscar pessoas:", error);
        alert("Erro ao buscar pessoas.");
    }
}
