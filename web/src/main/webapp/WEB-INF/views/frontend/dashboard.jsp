<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 5/20/2024
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Logistics System</title>
    <!-- Include CSS stylesheets -->
    <link rel="stylesheet" href="${assets}/css/style_dashboard.css">
</head>
<body>
<!-- Navigation Bar -->
<header>
    <div class="logo">Logistics System</div>
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Reports</a></li>
        </ul>
    </nav>
</header>

<!-- Main Content Area -->
<div class="container">
    <!-- Sidebar -->
    <aside>
        <ul>
            <li><a href="#">Overview</a></li>
            <li><a href="#">Shipments</a></li>
            <li><a href="#">Inventory</a></li>
            <li><a href="#">Analytics</a></li>
        </ul>
    </aside>

    <!-- Main Content -->
    <main>
        <!-- Chart Section -->
        <section id="charts">
            <h2>Analytics Overview</h2>
            <div class="chart" id="shipment-chart">
                <!-- Chart will be rendered here -->
            </div>
            <div class="chart" id="inventory-chart">
                <!-- Chart will be rendered here -->
            </div>
        </section>

        <!-- Table Section -->
        <section id="tables">
            <h2>Recent Shipments</h2>
            <div class="table" id="shipment-table">
                <!-- Table will be rendered here -->
            </div>
            <h2>Inventory Status</h2>
            <div class="table" id="inventory-table">
                <!-- Table will be rendered here -->
            </div>
            <h2>Cargo Items</h2>
            <div class="table" id="cargo-table">
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Weight</th>
                        <th>Destination</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Table rows will be dynamically populated here -->
                    </tbody>
                </table>
            </div>
        </section>
    </main>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2024 Logistics Management System</p>
</footer>

<!-- Include JavaScript files -->
<script>
    // Toggle Sidebar
    const sidebarToggleBtn = document.getElementById('sidebar-toggle');
    const sidebar = document.querySelector('aside');

    sidebarToggleBtn.addEventListener('click', () => {
        sidebar.classList.toggle('active');
    });

    // Handle Navigation
    const navLinks = document.querySelectorAll('nav ul li a');

    navLinks.forEach(link => {
        link.addEventListener('click', () => {
            // Remove active class from all links
            navLinks.forEach(navLink => navLink.classList.remove('active'));
            // Add active class to clicked link
            link.classList.add('active');
        });
    });

    // Chart Interactivity (Assuming you're using a chart library like Chart.js)
    const chartCanvas = document.getElementById('myChart');

    // Code to initialize or update chart data goes here

    // Table Interactivity
    const tableRows = document.querySelectorAll('.table tbody tr');

    tableRows.forEach(row => {
        row.addEventListener('click', () => {
            // Highlight clicked row
            tableRows.forEach(tableRow => tableRow.classList.remove('active'));
            row.classList.add('active');
            // Add logic to display row details or perform other actions
        });
    });

    function fetchCargoData() {
        fetch('/cargo', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(function(response) {
                return response.json();
            })
            .then(function(data) {
                let cargoTableBody = document.getElementById('cargo-table-body');
                cargoTableBody.innerHTML = '';

                data.forEach(function(cargo) {
                    let nameCell = document.createElement('td');
                    let weightCell = document.createElement('td');
                    let row = document.createElement('tr');
                    let destinationCell = document.createElement('td');
                    let statusCell = document.createElement('td');

                    nameCell.textContent = cargo.name;
                    weightCell.textContent = cargo.weight;
                    destinationCell.textContent = cargo.destination;
                    statusCell.textContent = cargo.status;

                    row.appendChild(nameCell);
                    row.appendChild(weightCell);
                    row.appendChild(destinationCell);
                    row.appendChild(statusCell);

                    cargoTableBody.appendChild(row);
                });
            })
            .catch(function(error) {
                console.error('Error fetching cargo data:', error);
            });
    }

    window.addEventListener('load', fetchCargoData);
</script>
</body>
</html>
