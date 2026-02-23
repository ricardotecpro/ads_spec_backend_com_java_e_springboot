# Projeto 11 - Blindagem de API 🏗️

**Objetivo**: Implementar camadas avançadas de segurança e renovação de tokens.

## O Desafio
Fortaleça sua API de login:

1.  **Helmet**: Instale e configure o Helmet para proteger os Headers.
2.  **CORS**: Restrinja o acesso à API para que apenas o domínio `http://localhost:3000` possa consultá-la.
3.  **Refresh Token**: Implemente uma rota `/refresh` que receba um refresh token, valide-o no banco (ou lista em memória) e gere um novo `accessToken`.
4.  **Rate Limit**: Adicione uma trava para que ninguém possa tentar logar mais de 5 vezes em 1 minuto.

## O que avaliar?
- Configuração correta das origens no CORS.
- Lógica de expiração do Refresh Token (ele deve durar muito mais que o Access Token).
- Verificação se o Helmet está realmente escondendo o header `X-Powered-By`.