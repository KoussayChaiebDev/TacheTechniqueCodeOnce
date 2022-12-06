import React, { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container } from "@mui/system";
import { Paper, Button } from "@mui/material";

export default function Product({ products }) {
  const paperStyle = {
    padding: "50 px 20 px",
    width: 600,
    margin: "20px auto",
  };

  const [name, setName] = React.useState("");
  const [category, setCategory] = React.useState("");
  const [stock, setStock] = React.useState("");

  const [data, setData] = useState({ data: [] });

  const handleClick = (e) => {
    e.preventDefault();
    const product = { name, category, stock };
    console.log(product);
    fetch("http://localhost:8080/products/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product),
    }).then(() => {
      console.log("New Product is added");
    });
  };

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1>Add Product</h1>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 1, width: "25ch" },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="outlined-basic"
            label="Product Name"
            variant="outlined"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />

          <TextField
            id="outlined-basic"
            label="Category"
            variant="outlined"
            fullWidth
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          />

          <TextField
            id="outlined-basic"
            label="Stock"
            variant="outlined"
            fullWidth
            value={stock}
            onChange={(e) => setStock(e.target.value)}
          />
          <Button variant="contained" onClick={handleClick} id="add">
            Add product to database
          </Button>
        </Box>
      </Paper>

      <Paper elevation={3} style={paperStyle}>
        <h1> Type in search bar to show desired category's products</h1>

        {products.map((product) => (
          <Paper
            elevation={6}
            style={{ margin: "10px", padding: "15px", textAlign: "left" }}
            key={product.id}
          >
            Id: {product.id} &nbsp; Name: {product.name} &nbsp; Category:{" "}
            {product.category} &nbsp; Stock: {product.stock}
          </Paper>
        ))}
        <br />
      </Paper>
    </Container>
  );
}
