const path = {
  home:'/',
  login: "/login",
  register: '/register',

  //profile
  profile: '/profile',
  address: '/profile-address',
  detailOrder: '/detail-order',
  
  //category:
  detailCategory: '/detail-category',

  //sản phẩm
  product: '/product',
  collectionsProduct: '/collections-product',
  collections: '/collections',
  detailProduct: '/detail-product',
  searchProduct: 'search-product',

  //giỏ hàng
  cart: '/cart',

  checkOut: '/check-out',
  thankYou: '/thank-you',
  offers :'offers',
  hotsale:'/hot-sale',

  //liên hệ
  contact: '/contact',
} as const;
 export default path;