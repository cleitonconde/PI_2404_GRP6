async function buscarPessoaPorNome() {
    const nome = prompt("Digite o nome da Pessoa Física:");
    if (!nome) return;
    const nomeCodificado = encodeURIComponent(nome);
    try {
        const response = await fetch(`http://localhost:8080/api/pessoas-fisicas/buscar?nome=${nomeCodificado}`);
        if (!response.ok) {
            throw new Error("Erro ao buscar pessoas");
        }

        const pessoas = await response.json();

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

function selecionarPessoa(pessoa) {
    document.getElementById("nome").value = pessoa.nome;
    document.getElementById("cpf").value = pessoa.cpf;
    fecharModal();
}

function fecharModal() {
    document.getElementById("modalPessoa").style.display = "none";
}



