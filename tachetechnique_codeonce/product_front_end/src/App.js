import "./App.css";
import AppBar from "./components/Appbar";
import Product from "./components/Product";
import * as React from "react";

function App() {
  const [produit, setProduit] = React.useState([]);

  return (
    <div>
      <AppBar setProduct={setProduit} />
      <Product products={produit} />
    </div>
  );
}

export default App;
