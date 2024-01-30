// server.js

const express = require('express');
const cors = require('cors');

const app = express();

// Enable CORS for all routes
app.use(cors());

// ... Your other routes and server setup ...

const port = 8080;
app.listen(port, () => {
  console.log(Server is running on http://localhost:${port});
});
