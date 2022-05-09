const user = {};
const id = window.localStorage.getItem("id");
window.addEventListener("load", function () {
  fetch(`https://asi2-backend-market.herokuapp.com/user/${id}`)
    .then((response) => response.json())
    .then((data) => getData(data));
});

const getData = (data) => {
  const user = {
    surName: data.surName,
    lastName: data.lastName,
    account: data.account,
  };

  let currentPage = "";
  if (window.location.href.includes("buy")) {
    currentPage = "Buy";
  } else if (window.location.href.includes("sell")) {
    currentPage = "Sell";
  } else if (window.location.href.includes("play")) {
    currentPage = "Play";
  } else if (window.location.href.includes("index")) {
    currentPage = "Home";
  }
  let template = document.querySelector("#navbar-content");
  let clone = document.importNode(template.content, true);

  newContent = clone.firstElementChild.innerHTML
    .replace(/{{money}}/g, user.account)
    .replace(/{{currentPage}}/g, currentPage)
    .replace(/{{login}}/g, user.surName);
  clone.firstElementChild.innerHTML = newContent;

  let cardContainer = document.querySelector("#gridContainer");
  cardContainer.appendChild(clone);

  const homeButton = document.getElementById("homeButton");
  homeButton?.addEventListener("click", () => {
    window.location.href = "../index.html";
  });
};

const cards = document.querySelectorAll(".card");

cards.forEach((card) => {
  card.addEventListener("click", function () {
    window.location.replace(
      `http://127.0.0.1:5500/Atelier-II-frontend/pages/${card.id}.html`
    );
  });
});
