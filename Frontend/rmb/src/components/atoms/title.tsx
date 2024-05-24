interface TitleProps {
  companyName?: string;
  description?: string;
}
// The title component
const Title = ({ companyName, description }: TitleProps) => {
  return (
    <div className="m-auto items-center">
      <h2 className="text-4xl font-bold text-white">{companyName}</h2>
      <p className="text-white">{description}</p>
    </div>
  );
};

export default Title;
