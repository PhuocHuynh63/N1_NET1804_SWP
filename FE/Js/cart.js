document.addEventListener("DOMContentLoaded", () => {
  const cartItems = document.querySelector("#cart-items");
  const totalQuantityElem = document.querySelector("#total-quantity");
  const totalPriceElem = document.querySelector("#total-price");
  const overlay = document.getElementById("overlay");

  function updateCart() {
    let totalQuantity = 0;
    let totalPrice = 0;

    cartItems.querySelectorAll("tr").forEach((row) => {
      const quantity = parseInt(row.querySelector(".quantity").value);
      const price = parseInt(row.querySelector(".price").textContent);
      const subtotal = quantity * price;

      row.querySelector(".subtotal").textContent =
        subtotal.toLocaleString() + "₫";
      totalQuantity += quantity;
      totalPrice += subtotal;
    });

    totalQuantityElem.textContent = totalQuantity;
    totalPriceElem.textContent = totalPrice.toLocaleString() + "₫";
  }

  cartItems.addEventListener("click", (e) => {
    if (
      e.target.classList.contains("plus-btn") ||
      e.target.classList.contains("minus-btn")
    ) {
      const quantityInput = e.target
        .closest(".quantity-control")
        .querySelector(".quantity");

      let quantity = parseInt(quantityInput.value);
      if (e.target.classList.contains("plus-btn")) {
        quantity += 1;
      } else if (e.target.classList.contains("minus-btn") && quantity > 0) {
        quantity -= 1;
      }

      quantityInput.value = quantity;
      updateCart();
    }

    if (e.target.classList.contains("remove-btn")) {
      e.target.closest("tr").remove();
      updateCart();
    }
  });

  function toggleCart() {
    const cartContainer = document.querySelector(".cart-container");
    if (
      cartContainer.style.display === "none" ||
      cartContainer.style.display === ""
    ) {
      cartContainer.style.display = "block";
      overlay.style.display = "block";
    } else {
      cartContainer.style.display = "none";
      overlay.style.display = "none";
    }
  }

  document.querySelector(".close-btn").addEventListener("click", toggleCart);
  overlay.addEventListener("click", toggleCart);

  updateCart();
});
