import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomePage from './pages/homePage/HomePage';
import Layout from './layout/Layout';
import Category from './pages/categoryPage/Category';

function App() {
  return (
    <div className="min-h-screen">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout Component={HomePage} />} />
          <Route path="/category/:category" element={<Layout Component={Category} />} />
       
          {/* <Route path="/" element={<About />} /> */}
          {/* <Route path="dashboard" element={<Dashboard />} /> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
