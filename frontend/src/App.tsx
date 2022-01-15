import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Listing from 'pages/Listing';
import Form from 'pages/Form';
import Navbar from "components/Navbar";

function App() {
  return (
    // Faz a configuração das rotas
    <BrowserRouter>
      <Navbar />

      {/* Configura rota por rota */}
      <Routes>
        <Route path="/" element={<Listing />} />

        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>

      </Routes>
    </BrowserRouter>
  );
}

export default App;
