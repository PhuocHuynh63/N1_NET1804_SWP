import React from 'react';
import { Link } from 'react-router-dom';

const Topbar = () => {
  return (
    <div className="topbar">
      <div className="topbar-bottom">
        <div className="container">
          <div className="box-content d-flex align-items-center justify-content-between">
            <div className="box-left d-flex flex-wrap align-items-center">
              <div className="hotline">
                <span>
                  Hotline : Group 3 - Net1804<Link to=""></Link> 
                </span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Topbar;
