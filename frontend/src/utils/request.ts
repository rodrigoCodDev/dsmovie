// Caso não esteja definida use por padrão localhost (??)
// REACT_APP_BACKEND_URL é uma variável do netlify
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? "http://localhost:8080"