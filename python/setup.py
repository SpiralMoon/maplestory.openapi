from setuptools import setup, find_packages

setup(
    name='maplestory-openapi',
    version='2.3.0',
    description='This Python library enables the use of the MapleStory OpenAPI of Nexon.',
    author='so99ynoodles',
    url='https://github.com/SpiralMoon/maplestory.openapi',
    long_description=open('README.md', 'r').read(),
    long_description_content_type='text/markdown',
    install_requires=[
        'pydantic <= 2.5.0',
        'requests <= 2.31.0'
    ],
    packages=find_packages(),
    license='MIT',
    python_requires='>=3.9',
)
