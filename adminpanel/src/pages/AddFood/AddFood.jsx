import React, { useState } from 'react';
import {assets} from '../../assets/assets'

const AddFood = () => {
  const [image, setImage] =useState(false);
  return (
    <div className="mx-2 mt-2">
  <div className="row ">
    <div className="card col-md-4">
      <div className="card-body ">
        <h2 className="mb-3">Add Food</h2>
        <form>
          <div className="mb-3">
            <label htmlFor="image" className="form-label">
              <img src={image? URL.createObjectURL(image):assets.upload} alt="" width={90} />
            </label>
            <input type="file" className="form-control" id="image"  required hidden onChange={(e) =>setImage(e.target.files[0])} />
          </div>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Name</label>
            <input type="text" className="form-control" id="name" name='name' required />
          </div>
          
          <div className="mb-3">
            <label htmlFor="description" className="form-label">Description</label>
            <textarea type="text" className="form-control" id="description" name='description' required />
          </div>
          <div className="mb-3">
            <label htmlFor="categoty" className="form-label">Category</label>
            <select name="categoty" id="categoty" className='form-control'>
              <option value="Biryani">Biryani</option>
              <option value="Cake">Cake</option>
              <option value="Pizza">Pizza</option>
              <option value="Burger">Burger</option>
              <option value="Rolls">Rolls</option>
              <option value="Salad">Salad</option>
              <option value="Ice cream">Ice cream</option>
            </select>
          </div>
          <div className="mb-3">
            <label htmlFor="price" className="form-label">Price</label>
            <input type="number" name='price' id='price' className='form-control' />
          </div>
          <button type="submit" className="btn btn-primary">Save</button>
        </form>
      </div>
    </div>
  </div>
</div>
  )
}

export default AddFood;